export default {
    data () {
      return {
        pagination: {}
      }
    },
    computed: {
      formatedSortString () {
        let sortStr = ''
        if (this.pagination.sortBy) {
          sortStr = `${this.pagination.sortBy},${ this.pagination.descending ? 'desc' : 'asc' }`
        }
        return sortStr
      }
    }
  }