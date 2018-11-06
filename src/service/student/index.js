import { http } from '../http'

export default {
    findAll (cb, errorCb, params) {
        http.get('/student/findAll', { params })
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    },
    save (cb, errorCb, student) {
        http.post('/student/save', student)
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    }
}