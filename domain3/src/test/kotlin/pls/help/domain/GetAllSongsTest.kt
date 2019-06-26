package pls.help.domain

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import io.reactivex.Single
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllSongsTest {

    lateinit var getAllSongs: GetAllSongs
    lateinit var selectSource: SelectSource

    @Mock
    lateinit var remote: RemoteRepository
    @Mock
    lateinit var local: LocalRepository

    @Before
    fun setUp() {
        remote.stub {
            on { getAllSingle() } doReturn Single.just(listOf(song(), song()))
        }
        local.stub {
            on { getAllSingle() } doReturn Single.just(listOf(song()))
        }
        getAllSongs = GetAllSongs()
        selectSource = SelectSource()
    }

    @Test
    fun name() {
        val songs = getAllSongs().test()

        songs.assertEmpty()

        selectSource(Source)

        assertTrue(songs.values().last().size == 1)

        selectSource(Source)

        assertTrue(songs.values().last().size == 3)

        selectSource(Source)

        assertTrue(songs.values().last().size == 1)
    }

    fun song() = Song()
}
