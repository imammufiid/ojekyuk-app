package com.mufiid.ojekyuk.data

object Mapper {
    fun mapUserResponse(userResponse: UserResponse?): List<User> {
        val mapper: (Data?) -> User = {
            User(
                id = it?.id ?: 0,
                email = it?.email.orEmpty(),
                name = "${it?.firstName.orEmpty()} ${it?.lastName.orEmpty()}"
            )
        }
        return userResponse?.data?.map(mapper).orEmpty()
    }
}