package pls.help.domain

import io.reactivex.Observable

class GetAllSongs {

    operator fun invoke(): Observable<List<Song>> =
        Observable.never()
}
