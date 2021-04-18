import React, {Component} from 'react';
import ProductDataService from '../../api/product/ProductDataService.js'

class InputComponent extends Component{
    constructor(props)
    {
        super(props)
        this.state = {
            skuname: '',
            hasSearchFailed: false
        }

        this.handleChange = this.handleChange.bind(this);
        this.filterClicked = this.filterClicked.bind(this);
    }
    render(){
        return(
            <div>
                <h1>Filter By Sku</h1>
                <div className="container">
                    {this.state.hasSearchFailed && <div className="alert alert-warning">Invalid skuname</div>}
                    SKU: <input type="text" name="skuname" value={this.state.skuname} onChange={this.handleChange} required/>
                    <button className="btn btn-success" onClick={this.filterClicked}> Filter</button>
                </div>
            </div>
        )
    }
    handleChange(event)
    {
        this.setState({
            [event.target.name] : event.target.value
        })
    }
    filterClicked()
    {
        ProductDataService.ifExists(this.state.skuname)
        .then(
            response=>{
                console.log('Successful')
                if (response.data)
                {
                    this.props.history.push(`/products/${this.state.skuname}`)
                }
                else{
                    this.setState({hasSearchFailed:true})
                }
            }
        )
        .catch(
            error=>{
                this.setState({hasSearchFailed:true})
            }
        )
    }
}
export default InputComponent