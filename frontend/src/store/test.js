import axios from 'axios'

export default{
  namespaced: true,
  state: () =>({
    str : "a"
  }),
  getters : {},
  mutations : {
    resetData(state) {
      state.str = ""
    },
    assignStr (state,payload){
      console.log("나실행됨")
      state.str = payload.str
      console.log("state.str"+state.str)
    }
  },
  //context.state
  actions: {
    async getStr({commit},payload) {
      try{
        console.log("payload"+payload)
        const res = await axios.get("http://localhost:9090/api/hello")
        // console.log(res)
        payload = res.data

        console.log("payload"+payload)
        commit('assignStr',{
          str : res.data
        })
      } catch(err){
        console.log(err);
      }
    }
  }

  
}