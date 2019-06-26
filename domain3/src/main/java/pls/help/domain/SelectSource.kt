package pls.help.domain

import io.reactivex.Completable

class SelectSource {

    operator fun invoke(source: Source) =
        Completable.fromAction {

        }
}
