package ly.raqam.t_rex_counter.counter_Page

import android.view.View
import androidx.annotation.RestrictTo.Scope
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ly.raqam.t_rex_counter.counter_Page.counterState.CounterState

class CounterViewModel : ViewModel() {
    var state = CounterState()
    var counterstate = MutableLiveData<CounterState>(state)

    fun icrement(){
        state.isLoading = true
        counterstate.value = state

viewModelScope.launch {
//
    start()
}



        state.count++


        evenoddch()

    }
    fun decrement(){
        state.count--
        //state.isLoading = false
        evenoddch()
        counterstate.value = state
    }
    fun evenoddch(){
        if (state.count % 2 == 0){
            state.evenodd = "even"
        }else
            state.evenodd = "odd"
    }
    suspend fun start(){
        delay(2000)

        state.isLoading = false
        counterstate.value = state
    }
}
