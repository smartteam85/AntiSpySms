package com.github.smartteamx.smsmanager.exceptions

class InvalidPageNumberException(page: Int) : RuntimeException("page number can't be $page")