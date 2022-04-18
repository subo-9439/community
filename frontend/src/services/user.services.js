import axios from 'axios';

// const API_URL = 'http://localhost:9090/api/';

class UserService {
  getHello() {
    return axios.get('http://localhost:9090/api/hello');
  }
}

export default new UserService();