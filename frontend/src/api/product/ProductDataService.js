import axios from "axios"

class ProductDataService
{
    retrieveAllProducts()
    {
        return axios.get(`http://localhost:8080/api/products`)
    }

    getProductsBySku(sku)
    {
        return axios.get(`http://localhost:8080/api/products/${sku}`);
    }

    ifExists(sku)
    {
        return axios.get(`http://localhost:8080/api/search/${sku}`);
    }

    getProduct(id)
    {
        return axios.get(`http://localhost:8080/api/product/${id}`);
    }

    updateProduct(id, product)
    {
        return axios.put(`http://localhost:8080/api/product/${id}`, product);
    }
}

export default new ProductDataService()