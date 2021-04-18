import React, {Component} from 'react';
import { Formik, Field, fieldset, Form, ErrorMessage } from 'formik'
import ProductDataService from '../../api/product/ProductDataService.js'

class ProductComponent extends Component{
    constructor(props)
    {
        super(props)
        this.state={
            id: this.props.location.pathname.split("/")[2],
            description: '',
            name:'',
            sku:''
        }
        this.onSubmit = this.onSubmit.bind(this)
        //this.validate = this.validate.bind(this)
    }
    componentDidMount()
    {
        if(this.state.id == -1)
        {
            return
        }
        ProductDataService.getProduct(this.state.id)
        .then(
            response =>{
                this.setState({
                    name: response.data.name,
                    description: response.data.description,
                    sku: response.data.sku

                })
            }
        )
    }
    onSubmit(values)
    {
        //console.log(values)
        let product = {id: this.state.id,
        name: values.name,
        description: values.description,
        sku: values.sku}
        ProductDataService.updateProduct(this.state.id, product)
        .then(response=>this.props.history.push(`/products/${values.sku}`))
        .catch(
            error=>{console.log(error)}
        )
        
    }
    
    render(){

        let {name,sku,description} = this.state
        return(
            <>
            <div className="container">
                <h1>
                    Product
                </h1>
                <Formik initialValues={{ description,name, sku}}
                    onSubmit={this.onSubmit}
                    //validateOnChange={false}
                    //validateOnBlur = {false}
                    //validate = {this.validate}
                    enableReinitialize = {true}
                >
                    {
                        props =>(
                            <Form>
                                <ErrorMessage name="description" component="div" className="alert alert-warning"></ErrorMessage>
                                <ErrorMessage name="targetDate" component="div" className="alert alert-warning"></ErrorMessage>
                                <fieldset className="form-group">
                                    <label> Name</label>
                                    <Field className="form-control"type="text" name="name"></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label> SKU</label>
                                    <Field className="form-control"type="text" name="sku" disabled></Field>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label> Description</label>
                                    <Field className="form-control"type="text" name="description"></Field>
                                </fieldset>
                                <button className="btn btn-success" type="submit" >Save</button>
                            </Form>
                        )
                    }
                </Formik>
            </div>
            </>
        )
    }
}
export default ProductComponent