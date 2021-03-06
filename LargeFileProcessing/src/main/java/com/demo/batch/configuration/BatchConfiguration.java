package com.demo.batch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.demo.batch.entity.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	/**
	 * FlatFileItemReader<T> Restartable ItemReader that reads lines from input
	 * setResource(Resource).
	 * 
	 * @return
	 */
	@Bean
	public FlatFileItemReader<Product> reader() {
		return new FlatFileItemReaderBuilder<Product>().name("productItemReader").linesToSkip(1)
				.resource(new ClassPathResource("inputs/products2.csv")).lineMapper(lineMapper())
				.recordSeparatorPolicy(new DefaultRecordSeparatorPolicy())
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {
					{
						setTargetType(Product.class);
					}
				}).build();
	}

	/**
	 * the lineMapper for mapping lines (strings) to domain objects typically used
	 * to map lines read from a file to domain objects on a per line basis.
	 * lineTokenizer to split string obtained typically from a file into tokens. In
	 * our example we are using DelimitedLineTokenizer that is because we are using
	 * csv file. fieldSetMapper to map data obtained from a FieldSet into an object.
	 * 
	 * @return
	 */
	@Bean
	public LineMapper<Product> lineMapper() {

		final DefaultLineMapper<Product> defaultLineMapper = new DefaultLineMapper<>();
		final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "name", "sku", "description" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });

		final ProductFieldSetMapper fieldSetMapper = new ProductFieldSetMapper();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}

	@Bean
	public ProductProcessor processor() {
		return new ProductProcessor();
	}

	/**
	 * The itemWriter object will set JDBC connection and sql statement is prepared
	 * for the batch action we want to perform in the database. A convenient
	 * implementation for providing BeanPropertySqlParameterSource when the item has
	 * JavaBean properties that correspond to names used for parameters in the SQL
	 * statement.
	 *
	 */
	@Bean
	public JdbcBatchItemWriter<Product> writer(final DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Product>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO product (name, sku, description) VALUES (:name, :sku, :description)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importProductJob(NotificationListener listener, Step step) {
		return jobBuilderFactory.get("importProductJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step).end().build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Product> writer) {
		return stepBuilderFactory.get("step1").<Product, Product>chunk(100).reader(reader()).processor(processor())
				.writer(writer).build();
	}
}
