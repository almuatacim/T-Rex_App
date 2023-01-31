package ly.raqam.t_rex_counter.counter_Page.counterState

data class CounterState(
    var isLoading: Boolean = false,
    var message : String = "",
    var count : Int = 0,
    var evenodd : String = "")