package functions

class User(val id: Int, val name: String, val address: String)

// Extracting a local function to avoid repetition
fun saveUser(user: User) {
    fun validate(
        user: User,
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // Save user to the database
}

// Accessing outer function parameters in a local function
fun saveUser2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " +
                        "empty $fieldName"
            )
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    // Save user to the database
}