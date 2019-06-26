package pls.help.domain

import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class SongsRepository(
    private val remote: RemoteRepository,
    private val local: LocalRepository
) {

    suspend operator fun invoke(sources: Set<Source>): List<Song> {
        val all = withContext(Dispatchers.IO) {
            sources.map {
                async { remote.getAllSuspend() }
            }
        }

        return all.awaitAll().flatten()
    }

    fun rxGetAll(sources: Set<Source>): Single<List<Song>> =
        Observable.fromIterable(sources)
            .map { local.getAllSingle() }
            .toList()
            .flatMap { Single.merge(it).toList() }
            .map { it.flatten() }

    // or

    suspend fun getLocal(): List<Song> = local.getAllSuspend()

    suspend fun getRemote(): List<Song> = remote.getAllSuspend()

    suspend fun getAll(): List<Song> =
        remote.getAllSuspend() + local.getAllSuspend()
}

/**
 * Pros/Cons?
 * Maintainability?
 * Project setup enforces good practices
 */
