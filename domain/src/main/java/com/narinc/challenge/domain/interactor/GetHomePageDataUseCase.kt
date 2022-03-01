package com.narinc.challenge.domain.interactor

import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.repository.HomePageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetHomePageDataBaseUseCase = BaseUseCase<Unit, Flow<List<HomePageData>>>

class GetHomePageDataUseCase @Inject constructor(
    private val repository: HomePageRepository
) : GetHomePageDataBaseUseCase {

    override suspend fun invoke(params: Unit) = repository.getHomePageData()
}
