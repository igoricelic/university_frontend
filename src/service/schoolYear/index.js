import { http } from '../http'

export default {
    findAll (cb, errorCb) {
        http.get('/schoolYear/findAll')
          .then(res => cb(res.data))
          .catch(err => errorCb(err))
    }
}
