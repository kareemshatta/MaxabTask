package com.kareem.domain.useCases

import com.kareem.domain.result.Resource


interface UseCase<I, O> {
    suspend fun execute(params: I): Resource<O>
}