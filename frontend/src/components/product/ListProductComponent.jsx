import React, {Component} from 'react';
import ProductDataService from '../../api/product/ProductDataService.js'

class ListProductComponent extends Component{
    constructor(props){
        super(props)
        this.state={
            products:[
            ],
            skuname :this.props.location.pathname.split("/")[2]
        }
        this.getProducts = this.getProducts.bind(this)
        this.getProductsBySku = this.getProductsBySku.bind(this)
        this.refreshProducts = this.refreshProducts.bind(this)
    }
    componentDidMount()
    {
        console.log(this.state.skuname)
        this.getProductsBySku(this.state.skuname);
    }

    refreshProducts() {
        ProductDataService.retrieveAllProducts()
            .then(
                response => {
                    //console.log(response);
                    this.setState({ products: response.data })
                }
            )
    }
    render(){
        return (
        <div>
        <div className="container">
            <h3>List of Products with sku: {this.state.skuname}</h3>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>SKU</th>
                        <th>Operation</th>
                    </tr>
                </thead>
                <tbody>
                {
                            this.state.products.map(
                                product =>
                                <tr key={product.id}>
                                    {/* <td>{todo.id}</td> */}
                                    <td>{product.name}</td>
                                    <td>{product.description}</td>
                                    <td>{product.sku}</td>
                                    <td><button className="btn btn-success" onClick={()=>this.updateProduct(product.id)}> Update</button></td>
                                </tr>
                            )
                         }
                </tbody>
            </table>
        </div>
        </div>
        )}

        getProducts()
        {
            ProductDataService.retrieveAllProducts()
            .then(
                response =>{
                    console.log(response)
                    this.setState({products:response.data})
                }
            )
            .catch(
                error => this.handleError(error)
            )
        }
        updateProduct(id)
        {
            console.log(id)
            //this.props.history.push(`/products/${this.state.skuname}`)
            this.props.history.push(`/product/${id}`)
        }
        getProductsBySku(skuname)
        {
            ProductDataService.getProductsBySku(skuname)
            .then(
                response =>{
                    console.log(response)
                    this.setState({products:response.data})
                }
            )
            .catch(
                error => this.handleError(error)
            )
        }
    
        handleError()
        {
    
        }
}
export default ListProductComponent