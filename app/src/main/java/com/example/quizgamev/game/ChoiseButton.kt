package com.example.quizgamev.game

import android.content.Context
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class ChoiceButton : androidx.appcompat.widget.AppCompatButton {

    private var uiState: ChoiceUiState = ChoiceUiState.Empty

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        freezesText = true
    }

    fun updateState(newState: ChoiceUiState) {
        uiState = newState
        uiState.show(this)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ChoiceUiButtonSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ChoiceUiButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateState(restoredState.restore())
    }
}

class ChoiceUiButtonSavedState : View.BaseSavedState {

    private lateinit var state: ChoiceUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            parcelIn.readSerializable(null, ChoiceUiState::class.java)!!
        else
            parcelIn.readSerializable() as ChoiceUiState
    }

    fun save(data: ChoiceUiState) {
        state = data
    }

    fun restore() = state

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ChoiceUiButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): ChoiceUiButtonSavedState =
            ChoiceUiButtonSavedState(parcel)

        override fun newArray(size: Int): Array<ChoiceUiButtonSavedState?> =
            arrayOfNulls(size)
    }
}