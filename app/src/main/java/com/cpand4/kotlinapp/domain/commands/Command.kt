package com.cpand4.kotlinapp.domain.commands

/**
 * Created by stefano on 24/12/2018.
 */

public interface Command<out T> {
    fun execute() : T
}