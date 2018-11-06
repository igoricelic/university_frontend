<template>
    <v-dialog v-model="dialog" class="relative" persistent max-width="800">
        <v-card class="relative add-content">
            <v-btn
                fab
                small
                class="dms-top-right-x link-feel"
                @click.prevent="closeModal">
                <v-icon>close</v-icon>
            </v-btn>
            <form>
                <v-layout row justify-center>
                    <v-flex md10>
                        <h2>Proffesor details</h2>
                    </v-flex>
                </v-layout>

                <v-layout row justify-center>
                        <v-flex md10>
                            <v-text-field
                            name="firstName"
                            v-model="currProffesor.firstName"
                            label="First name"
                            :readonly="true"
                            ></v-text-field>
                        </v-flex>
                    </v-layout>

                    <v-layout row justify-center>
                        <v-flex md10>
                            <v-text-field
                            name="lastName"
                            v-model="currProffesor.lastName"
                            label="Last name"
                            :readonly="true"
                            ></v-text-field>
                        </v-flex>
                    </v-layout>

                    <v-layout row justify-center>
                        <v-flex md10>
                            <v-list>
                                <v-list-tile
                                    v-for="item in currProffesor.subjects"
                                    :key="item.name"
                                >
                                <v-list-tile-content>
                                    <v-list-tile-title v-text="item.name"></v-list-tile-title>
                                </v-list-tile-content>
                            </v-list-tile>
                    </v-list>
                        </v-flex>
                    </v-layout>
            </form>
        </v-card>
    </v-dialog>
</template>


<script>
export default {
    props: {
        currProffesor: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            dialog: true
        }
    },
    methods: {
        closeModal () {
            this.dialog = false
            this.$emit('close')
        }
    },
    mounted: function () {
    }
}
</script>
