/**
 * copyRight
 *//*

package com.gennlife.masterworker;

*/
/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/7/5
 * Time: 15:05
 *//*

public class AAA {

    //删除字段
    let deleteField = function (json, key) {
        delete json[key]
    };
    let objs = data.active.config[0].conditions;

    // 数据修改
    let split = function (object) {
        console.log(object);
        if (Array.isArray(object)) {
            console.log("是数组");
            for (let i = 0; i < object.length; i++) {
                let positioningBox = [];

                //判断数组是否有效
                if (!object[i].hasOwnProperty("details") && !object[i].hasOwnProperty("inner")) {
                    console.log("不存在");
                    continue;
                }

                //把details、inner、placeholder放到一个数组中以便排序
                if (object[i].hasOwnProperty("details")) {
                    for (let j = 0; j < object[i].details.length; j++) {
                        positioningBox.push(object[i].details[j])
                    }
                    new deleteField (object[i],"details");
                    object[i].positioningBox = positioningBox;
                }
                if (object[i].hasOwnProperty("inner")) {
                    for (let j = 0; j < object[i].inner.length; j++) {
                        positioningBox.push(object[i].inner[j])
                    }
                    new deleteField (object[i],"inner");
                    object[i].positioningBox = positioningBox;
                }
                if (object[i].hasOwnProperty("placeholder")) {
                    for (let j = 0; j < object[i].placeholder.length; j++) {
                        positioningBox.push(object[i].placeholder[j])
                    }
                    new deleteField (object[i],"placeholder");
                    object[i].positioningBox = positioningBox;
                }
                for (let m = 0; m < object[i].positioningBox.length; m++) {
                    switch (object[i].positioningBox[m].nodeType)
                    {
                        case "details":
                            break;
                        case "inner":
                            // console.log(m);
                            // console.log(Array[i].positioningBox[m]);
                            new split(object[i].positioningBox[m]);
                            break;
                        case "placeholder":
                            break;
                    }
                }
            }
        } else {

            let positioningBox = [];

            //判断数组是否有效
            if (!object.hasOwnProperty("details") && !object.hasOwnProperty("inner")) {
                console.log("不存在");
            } else {
                //把details、inner、placeholder放到一个数组中以便排序
                if (object.hasOwnProperty("details")) {
                    for (let j = 0; j < object.details.length; j++) {
                        positioningBox.push(object.details[j])
                    }
                    new deleteField (object,"details");
                    object.positioningBox = positioningBox;
                }
                if (object.hasOwnProperty("inner")) {
                    for (let j = 0; j < object.inner.length; j++) {
                        positioningBox.push(object.inner[j])
                    }
                    new deleteField (object,"inner");
                    object.positioningBox = positioningBox;
                }
                if (object.hasOwnProperty("placeholder")) {
                    for (let j = 0; j < object.placeholder.length; j++) {
                        positioningBox.push(object.placeholder[j])
                    }
                    new deleteField (object,"placeholder");
                    object.positioningBox = positioningBox;
                }
            }


            console.log("不是数组");
        }

    };
}
*/
