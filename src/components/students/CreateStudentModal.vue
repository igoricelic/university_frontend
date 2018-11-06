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
                <h2>Create new student</h2>
            </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="index"
                    v-model="student.index"
                    label="Index"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="firstName"
                    v-model="student.firstName"
                    label="First name"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="lastName"
                    v-model="student.lastName"
                    label="Last Name"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>
            

            <v-layout row justify-center>
            <v-flex md10>
                <v-btn color="primary" @click="save">Save</v-btn>
            </v-flex>
            </v-layout>
        </form>
        </v-card>
    </v-dialog>
</template>

<script>
export default {
    data () {
        return {
            dialog: true,
            student: {
                index: '',
                firstName: '',
                lastName: ''
            }
        }
    },
    methods: {
        closeModal () {
            this.dialog = false
            this.$emit('close')
        },
        save () {
            this.$store.dispatch('0/createStudent', this.student)
                .then(response => {
                    this.$emit('close')
                })
                .catch(error => {
                    console.log(error)
                })
        }
    }
}
</script>
