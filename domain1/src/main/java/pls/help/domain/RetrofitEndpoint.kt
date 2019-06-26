package pls.help.domain

interface RetrofitEndpoint {
    suspend fun makeCall(): List<Song>
}
