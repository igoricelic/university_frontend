import { http } from "../http";

export default {
  findAll(cb, errorCb, params) {
    http
      .get("/exam/findAll", { params })
      .then(res => cb(res.data))
      .catch(err => errorCb(err));
  },
  findByPath(cb, errorCb, path) {
    let address = `/exam/findAll?${path}`;
    http
      .get(address)
      .then(res => cb(res.data))
      .catch(err => errorCb(err));
  },
  findById(cb, errorCb, params) {
    http
      .get("/exam/findById", { params })
      .then(res => cb(res.data))
      .catch(err => errorCb(err));
  },
  save(cb, errorCb, proffesor) {
    http
      .post("/exam/save", proffesor)
      .then(res => cb(res.data))
      .catch(err => errorCb(err));
  }
};
