import axios from "axios";

const http = axios.create({
    baseURL: 'http://localhost:9000',
    timeout: 1000 * 10
})

export default http