import { http } from '../http'

export default {
    findAll (cb, errorCb, params) {
        http.get('/proffesor/findAll', { params })
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    },
    findById (cb, errorCb, params) {
        http.get('/proffesor/findById', { params })
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    },
    save (cb, errorCb, proffesor) {
        http.post('/proffesor/save', proffesor)
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    }
}