package com.example.quizgamev

import android.content.Context
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class ActionButton : androidx.appcompat.widget.AppCompatButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        freezesText = true
        setBackgroundColor(Color.parseColor("#6AD9E8"))
    }

    fun updateState(newState: Int) {
        visibility=newState
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionButtonSavedState(it)
            state.save(visibility)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateState(restoredState.restore())
    }
}

class ActionButtonSavedState : View.BaseSavedState {

    private var state: Int =0

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = parcelIn.readInt()

    }

    fun save(data: Int) {
        state = data
    }

    fun restore() = state

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeInt(state)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ActionButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): ActionButtonSavedState =
            ActionButtonSavedState(parcel)

        override fun newArray(size: Int): Array<ActionButtonSavedState?> =
            arrayOfNulls(size)
    }
}
