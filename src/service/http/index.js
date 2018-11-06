import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8088/'
})

axiosInstance.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'

const http = axiosInstance

export { http }
