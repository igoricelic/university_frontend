import { http } from '../http'

export default {
    findAll (cb, errorCb, params) {
        http.get('/subject/findAll', { params })
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    },
    save (cb, errorCb, subject) {
        http.post('/subject/save', subject)
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    }
}