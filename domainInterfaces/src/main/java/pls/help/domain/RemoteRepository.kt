package pls.help.domain

import io.reactivex.Observable
import io.reactivex.Single

interface RemoteRepository {
    fun getAllSingle(): Single<List<Song>>
    fun getAllObservable(): Observable<Song>
    fun getAllSynch(): List<Song>
    suspend fun getAllSuspend(): List<Song>
}

interface DataRepository {
    suspend fun getLocal(): List<Song>
    suspend fun getRemote(): List<Song>
}

interface LocalRepository {
    suspend fun getAllSuspend(): List<Song>
    fun getAllSingle(): Single<List<Song>>
}
