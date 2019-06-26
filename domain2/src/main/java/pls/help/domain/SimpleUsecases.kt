package pls.help.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class GetRemoteSongsUseCase(
    private val remote: RemoteRepository
) {

    suspend operator fun invoke(): List<Song> =
        remote.getAllSuspend()
}

class GetLocalSongsUseCase(
    private val local: LocalRepository
) {

    suspend operator fun invoke(): List<Song> =
        local.getAllSuspend()
}

class GetAllSongsUseCase(
    private val remote: GetRemoteSongsUseCase,
    private val local: GetLocalSongsUseCase
) {

    suspend operator fun invoke(): List<Song> =
        local() + remote()
}

class GetSongsBySource(
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
}

/**
 * Pros/Cons?
 * Maintainability?
 */
