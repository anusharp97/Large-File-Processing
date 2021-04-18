import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListProductComponent from './ListProductComponent'
import InputComponent from './InputComponent'
import ProductComponent from './ProductComponent'

class ProductApp extends Component{
    render(){
        return(
            <div className="ProductApp">
            <Router>
                <>
                    <Switch>
                        <Route path="/" exact component={InputComponent}/>
                        <Route path="/input" component={InputComponent}/>
                        <Route path="/product/:id"  component={ProductComponent}/>
                        <Route path="/products" component={ListProductComponent}/>
                        <Route path="/products/:skuname" component={ListProductComponent}/>
                        
                    </Switch>
                </>
            </Router>
            </div>
        )}
}
export default ProductApp