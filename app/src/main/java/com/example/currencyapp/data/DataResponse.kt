package com.example.currencyapp.data

class DataResponse {
    companion object {
        /**
         * 성공한 요청
         */
        const val OK = 0

        /**
         * 잘못된 요청
         */
        const val BAD_REQUEST = 400

        /**
         * 서버내부오류
         */
        const val INTERNAL_SERVER_ERROR = 500

        /**
         * API 조회 횟수 초과
         */
        const val NOT_IMPLEMENTED = 501
    }
}