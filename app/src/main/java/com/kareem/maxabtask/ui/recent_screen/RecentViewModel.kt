package com.kareem.maxabtask.ui.recent_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kareem.data.models.PageInfoModel
import com.kareem.domain.models.MovieVM
import com.kareem.domain.result.Resource
import com.kareem.domain.useCases.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
) : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieVM>>(emptyList())
    val movies: MutableStateFlow<List<MovieVM>> = _movies

    private val _screenLoading = MutableStateFlow(false)
    val screenLoading: MutableStateFlow<Boolean> get() = _screenLoading

    val pageInfoModel = PageInfoModel.init()

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            _screenLoading.value = true
            when (val result = getNowPlayingMoviesUseCase.execute(params = GetNowPlayingMoviesUseCase.Params(pageInfoModel.pageNumber))) {
                is Resource.Success -> {
                    _screenLoading.value = false
                    _movies.value = result.data ?: emptyList()
                    handlePaging(_movies.value)
                }
                is Resource.Error -> {
                    _screenLoading.value = false
                    _movies.value = emptyList()
                }
                else -> {}
            }
        }
    }

    private fun handlePaging(movies: List<MovieVM>) {
        if (movies.isNotEmpty())
            pageInfoModel.pageNumber++
        else
            pageInfoModel.hasNext = false
    }
}