package com.vxg.mrrtest.service.entity

/**
 * Created by vxg on 2017-10-17-0017.
 */

class Book {

    /**
     * count : 1
     * start : 0
     * total : 545
     * books : [{"rating":{"max":10,"numRaters":4294,"average":"8.6","min":0},"subtitle":"张竹坡批评第一奇书","author":["兰陵笑笑生"],"pubdate":"1991","tags":[{"count":2050,"name":"金瓶梅","title":"金瓶梅"},{"count":1188,"name":"古典文学","title":"古典文学"},{"count":866,"name":"兰陵笑笑生","title":"兰陵笑笑生"},{"count":759,"name":"小说","title":"小说"},{"count":652,"name":"中国古典文学","title":"中国古典文学"},{"count":428,"name":"中国文学","title":"中国文学"},{"count":372,"name":"古典","title":"古典"},{"count":360,"name":"中国","title":"中国"}],"origin_title":"（明）兰陵笑笑生","image":"https://img1.doubanio.com/mpic/s10069398.jpg","binding":"","translator":[],"catalog":"\n      ","pages":"","images":{"small":"https://img1.doubanio.com/spic/s10069398.jpg","large":"https://img1.doubanio.com/lpic/s10069398.jpg","medium":"https://img1.doubanio.com/mpic/s10069398.jpg"},"alt":"https://book.douban.com/subject/1456692/","id":"1456692","publisher":"齐鲁出版社","isbn10":"7533300815","isbn13":"9787533300814","title":"金瓶梅","url":"https://api.douban.com/v2/book/1456692","alt_title":"（明）兰陵笑笑生","author_intro":"","summary":"本书由王汝梅与李昭恂、于凤树校点。","series":{"id":"4279","title":"明代四大奇书"},"price":"268.00元"}]
     */

    var count: Int = 0
    var start: Int = 0
    var total: Int = 0
    var books: List<BooksBean>? = null

    class BooksBean {
        /**
         * rating : {"max":10,"numRaters":4294,"average":"8.6","min":0}
         * subtitle : 张竹坡批评第一奇书
         * author : ["兰陵笑笑生"]
         * pubdate : 1991
         * tags : [{"count":2050,"name":"金瓶梅","title":"金瓶梅"},{"count":1188,"name":"古典文学","title":"古典文学"},{"count":866,"name":"兰陵笑笑生","title":"兰陵笑笑生"},{"count":759,"name":"小说","title":"小说"},{"count":652,"name":"中国古典文学","title":"中国古典文学"},{"count":428,"name":"中国文学","title":"中国文学"},{"count":372,"name":"古典","title":"古典"},{"count":360,"name":"中国","title":"中国"}]
         * origin_title : （明）兰陵笑笑生
         * image : https://img1.doubanio.com/mpic/s10069398.jpg
         * binding :
         * translator : []
         * catalog :
         *
         * pages :
         * images : {"small":"https://img1.doubanio.com/spic/s10069398.jpg","large":"https://img1.doubanio.com/lpic/s10069398.jpg","medium":"https://img1.doubanio.com/mpic/s10069398.jpg"}
         * alt : https://book.douban.com/subject/1456692/
         * id : 1456692
         * publisher : 齐鲁出版社
         * isbn10 : 7533300815
         * isbn13 : 9787533300814
         * title : 金瓶梅
         * url : https://api.douban.com/v2/book/1456692
         * alt_title : （明）兰陵笑笑生
         * author_intro :
         * summary : 本书由王汝梅与李昭恂、于凤树校点。
         * series : {"id":"4279","title":"明代四大奇书"}
         * price : 268.00元
         */

        var rating: RatingBean? = null
        var subtitle: String? = null
        var pubdate: String? = null
        var origin_title: String? = null
        var image: String? = null
        var binding: String? = null
        var catalog: String? = null
        var pages: String? = null
        var images: ImagesBean? = null
        var alt: String? = null
        var id: String? = null
        var publisher: String? = null
        var isbn10: String? = null
        var isbn13: String? = null
        var title: String? = null
        var url: String? = null
        var alt_title: String? = null
        var author_intro: String? = null
        var summary: String? = null
        var series: SeriesBean? = null
        var price: String? = null
        var author: List<String>? = null
        var tags: List<TagsBean>? = null
        var translator: List<*>? = null

        class RatingBean {
            /**
             * max : 10
             * numRaters : 4294
             * average : 8.6
             * min : 0
             */

            var max: Int = 0
            var numRaters: Int = 0
            var average: String? = null
            var min: Int = 0
        }

        class ImagesBean {
            /**
             * small : https://img1.doubanio.com/spic/s10069398.jpg
             * large : https://img1.doubanio.com/lpic/s10069398.jpg
             * medium : https://img1.doubanio.com/mpic/s10069398.jpg
             */

            var small: String? = null
            var large: String? = null
            var medium: String? = null
        }

        class SeriesBean {
            /**
             * id : 4279
             * title : 明代四大奇书
             */

            var id: String? = null
            var title: String? = null
        }

        class TagsBean {
            /**
             * count : 2050
             * name : 金瓶梅
             * title : 金瓶梅
             */

            var count: Int = 0
            var name: String? = null
            var title: String? = null
        }
    }

    public fun debug() : String{
        var debug: StringBuffer = StringBuffer();
        for (i in this.books!!.indices){
            val book : BooksBean = this.books!!.get(i)
            debug.append("第").append(i+1).append("本: 《")
            debug.append(book.title).append("》\n")
            debug.append("原著名：").append(book.alt_title).append("\n")
            debug.append("作者：").append(book.author!!.get(0)).append("\n")
            debug.append("出版时间：").append(book.pubdate).append("\n")
            debug.append("出版社：").append(book.publisher).append("\n")
            debug.append("发行价：").append(book.price).append("\n")
            debug.append("简介：").append(book.summary).append("\n")
        }
        if (debug.isEmpty()) return "啥也没查到"
        return debug.toString()
    }
}
