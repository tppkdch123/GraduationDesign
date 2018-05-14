package org.graduationdesign.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private Long id;

    private Long orderId;

    private Integer descriptScore;

    private String content;

    private Boolean isAnonymous;

    private Boolean isDelete;

    private Integer chatScore;

    private Integer hygineneScore;

    private Integer locationScore;

    private Integer costScore;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDescriptScore() {
        return descriptScore;
    }

    public void setDescriptScore(Integer descriptScore) {
        this.descriptScore = descriptScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getChatScore() {
        return chatScore;
    }

    public void setChatScore(Integer chatScore) {
        this.chatScore = chatScore;
    }

    public Integer getHygineneScore() {
        return hygineneScore;
    }

    public void setHygineneScore(Integer hygineneScore) {
        this.hygineneScore = hygineneScore;
    }

    public Integer getLocationScore() {
        return locationScore;
    }

    public void setLocationScore(Integer locationScore) {
        this.locationScore = locationScore;
    }

    public Integer getCostScore() {
        return costScore;
    }

    public void setCostScore(Integer costScore) {
        this.costScore = costScore;
    }

}
/**
 *+-------------+-------------+------+-----+---------+-------+
 | Field       | Type        | Null | Key | Default | Extra |
 +-------------+-------------+------+-----+---------+-------+
 | id          | int(11)     | NO   | PRI | NULL    |       |
 | province_id | int(11)     | NO   | MUL | NULL    |       |
 | name        | varchar(45) | YES  |     | NULL    |       |
 | pinyin      | varchar(45) | YES  |     | NULL    |       |
 | acronym     | varchar(25) | YES  |     | NULL    |       |
 | first_char  | varchar(10) | YES  |     | NULL    |       |
 | rank        | char(5)     | YES  |     | NULL    |       |
 +-------------+-------------+------+-----+---------+-------+
 +------------------------+--------------+------+-----+---------+----------------+
 | Field                  | Type         | Null | Key | Default | Extra          |
 +------------------------+--------------+------+-----+---------+----------------+
 | id                     | bigint(20)   | NO   | PRI | NULL    | auto_increment |
 | provider_id            | bigint(20)   | NO   | MUL | NULL    |                |
 | title                  | varchar(255) | YES  |     | NULL    |                |
 | default_price          | int(11)      | YES  |     | NULL    |                |
 | max_capacity           | int(11)      | NO   |     | 1       |                |
 | introduction           | text         | YES  |     | NULL    |                |
 | usable_area            | int(11)      | YES  |     | 0       |                |
 | structure              | varchar(20)  | YES  |     | NULL    |                |
 | create_time            | timestamp    | YES  |     | NULL    |                |
 | update_time            | timestamp    | YES  |     | NULL    |                |
 | around_info            | text         | YES  |     | NULL    |                |
 | real_check             | tinyint(1)   | NO   |     | NULL    |                |
 | bed_count              | int(11)      | YES  |     | NULL    |                |
 | comment_number         | int(11)      | YES  |     | NULL    |                |
 | host_message           | varchar(45)  | YES  |     | NULL    |                |
 | latitude               | float        | YES  |     | NULL    |                |
 | longitude              | float        | YES  |     | NULL    |                |
 | street                 | varchar(255) | YES  |     | NULL    |                |
 | is_delete              | tinyint(1)   | NO   |     | NULL    |                |
 | is_onsale              | tinyint(1)   | NO   |     | NULL    |                |
 | city_id                | int(11)      | YES  | MUL | NULL    |                |
 | province_id            | int(11)      | YES  | MUL | NULL    |                |
 | district_id            | bigint(10)   | YES  | MUL | NULL    |                |
 | block                  | varchar(255) | YES  |     | NULL    |                |
 | area_id                | bigint(10)   | YES  | MUL | NULL    |                |
 | move_up_cancel_days    | int(11)      | YES  |     | NULL    |                |
 | earliest_check_in_time | varchar(10)  | YES  |     | NULL    |                |
 | lastest_check_in_time  | varchar(10)  | YES  |     | NULL    |                |
 | lastest_check_out_time | varchar(10)  | YES  |     | NULL    |                |
 | description            | text         | YES  |     | NULL    |                |
 +-----------------------------------

 *
 *
 *
 * +-------------+------------+------+-----+---------+----------------+
 | Field       | Type       | Null | Key | Default | Extra          |
 +-------------+------------+------+-----+---------+----------------+
 | id          | bigint(20) | NO   | PRI | NULL    | auto_increment |
 | user_id     | bigint(20) | NO   | MUL | NULL    |                |
 | room_id     | bigint(20) | NO   | MUL | NULL    |                |
 | create_time | timestamp  | YES  |     | NULL    |                |
 | update_time | timestamp  | YES  |     | NULL    |                |
 | is_delete   | tinyint(1) | NO   |     | NULL    |                |
 +-------------+------------+------+-----+---------+----------------+

 +----------------+--------------+------+-----+---------+----------------+
 | Field          | Type         | Null | Key | Default | Extra          |
 +----------------+--------------+------+-----+---------+----------------+
 | id             | bigint(20)   | NO   | PRI | NULL    | auto_increment |
 | order_id       | bigint(20)   | NO   | UNI | NULL    |                |
 | descript_score | int(11)      | NO   |     | 500     |                |
 | content        | varchar(255) | YES  |     | NULL    |                |
 | is_anonymous   | tinyint(1)   | NO   |     | NULL    |                |
 | is_delete      | tinyint(1)   | NO   |     | NULL    |                |
 | chat_score     | int(11)      | NO   |     | 500     |                |
 | hyginene_score | int(11)      | NO   |     | 500     |                |
 | location_score | int(11)      | NO   |     | 500     |                |
 | cost_score     | int(11)      | NO   |     | 500     |                |
 +----------------+--------------+------+-----+---------+----------------+

 +---------+------------+------+-----+---------+-------+
 | Field   | Type       | Null | Key | Default | Extra |
 +---------+------------+------+-----+---------+-------+
 | room_id | bigint(20) | NO   | PRI | NULL    |       |
 | date    | date       | NO   | PRI | NULL    |       |
 | price   | float      | YES  |     | 0       |       |
 +---------+------------+------+-----+---------+-------+

 +---------+-------------+------+-----+---------+-------+
 | Field   | Type        | Null | Key | Default | Extra |
 +---------+-------------+------+-----+---------+-------+
 | id      | bigint(10)  | NO   | PRI | NULL    |       |
 | city_id | int(11)     | NO   | MUL | NULL    |       |
 | name    | varchar(45) | YES  |     | NULL    |       |
 | pinyin  | varchar(45) | YES  |     | NULL    |       |
 +---------+-------------+------+-----+---------+-------+

 +------------------+-------------+------+-----+---------+-------+
 | Field            | Type        | Null | Key | Default | Extra |
 +------------------+-------------+------+-----+---------+-------+
 | id               | int(11)     | NO   | PRI | NULL    |       |
 | level_name       | varchar(45) | NO   |     | NULL    |       |
 | level_need_score | int(11)     | NO   |     | NULL    |       |
 | level_type       | tinyint(4)  | NO   |     | 0       |       |
 | type             | int(11)     | YES  |     | NULL    |       |
 +------------------+-------------+------+-----+---------+-------+

 +-------+-------------+------+-----+---------+-------+
 | Field | Type        | Null | Key | Default | Extra |
 +-------+-------------+------+-----+---------+-------+
 | id    | int(11)     | NO   | PRI | NULL    |       |
 | type  | int(11)     | NO   |     | NULL    |       |
 | value | varchar(45) | NO   |     | NULL    |       |
 +-------+-------------+------+-----+---------+-------+

 +------------+--------------+------+-----+---------+----------------+
 | Field      | Type         | Null | Key | Default | Extra          |
 +------------+--------------+------+-----+---------+----------------+
 | id         | bigint(20)   | NO   | PRI | NULL    | auto_increment |
 | room_id    | bigint(20)   | NO   | MUL | NULL    |                |
 | meta_id    | int(11)      | NO   | MUL | NULL    |                |
 | meta_value | varchar(500) | YES  |     | NULL    |                |
 | is_delete  | tinyint(1)   | NO   |     | NULL    |                |
 +------------+--------------+------+-----+---------+----------------+

 +---------------+------------+------+-----+---------+----------------+
 | Field         | Type       | Null | Key | Default | Extra          |
 +---------------+------------+------+-----+---------+----------------+
 | id            | bigint(20) | NO   | PRI | NULL    | auto_increment |
 | room_id       | bigint(20) | NO   | MUL | NULL    |                |
 | user_id       | bigint(20) | NO   | MUL | NULL    |                |
 | create_time   | timestamp  | YES  |     | NULL    |                |
 | start_date    | date       | YES  |     | NULL    |                |
 | end_date      | date       | YES  |     | NULL    |                |
 | total_amount  | float      | YES  |     | NULL    |                |
 | discount      | float      | YES  |     | 0       |                |
 | actual_pay    | float      | YES  |     | NULL    |                |
 | coupon_amount | float      | YES  |     | NULL    |                |
 | order_status  | int(11)    | YES  |     | NULL    |                |
 | is_delete     | tinyint(1) | YES  |     | NULL    |                |
 +---------------+------------+------+-----+---------+----------------+

 +---------------+-------------+------+-----+---------+-------+
 | Field         | Type        | Null | Key | Default | Extra |
 +---------------+-------------+------+-----+---------+-------+
 | province_code | int(11)     | NO   | PRI | NULL    |       |
 | province_name | varchar(45) | YES  |     | NULL    |       |
 +---------------+-------------+------+-----+---------+-------+

 +--------------+------------+------+-----+---------+----------------+
 | Field        | Type       | Null | Key | Default | Extra          |
 +--------------+------------+------+-----+---------+----------------+
 | id           | bigint(20) | NO   | PRI | NULL    | auto_increment |
 | userId       | bigint(20) | NO   | UNI | NULL    |                |
 | credit_score | int(11)    | NO   |     | 0       |                |
 | join_time    | timestamp  | YES  |     | NULL    |                |
 | is_delete    | tinyint(1) | NO   |     | NULL    |                |
 +--------------+------------+------+-----+---------+----------------+
 +---------+--------------+------+-----+---------+----------------+
 | Field   | Type         | Null | Key | Default | Extra          |
 +---------+--------------+------+-----+---------+----------------+
 | room_id | bigint(20)   | NO   | MUL | NULL    |                |
 | type    | int(11)      | YES  |     | 1       |                |
 | value   | varchar(200) | YES  |     | NULL    |                |
 | info    | varchar(20)  | YES  |     | NULL    |                |
 | id      | bigint(20)   | NO   | PRI | NULL    | auto_increment |
 +---------+--------------+------+-----+---------+----------------+

 +-----------------+--------------+------+-----+---------+----------------+
 | Field           | Type         | Null | Key | Default | Extra          |
 +-----------------+--------------+------+-----+---------+----------------+
 | id              | bigint(20)   | NO   | PRI | NULL    | auto_increment |
 | email           | varchar(45)  | YES  | UNI | NULL    |                |
 | password        | varchar(255) | YES  |     | NULL    |                |
 | create_time     | timestamp    | YES  |     | NULL    |                |
 | update_time     | timestamp    | YES  |     | NULL    |                |
 | name            | varchar(45)  | YES  |     | NULL    |                |
 | mobile          | varchar(45)  | YES  |     | NULL    |                |
 | sex             | tinyint(1)   | NO   |     | NULL    |                |
 | user_avatar_url | varchar(255) | YES  |     | NULL    |                |
 | is_delete       | tinyint(1)   | NO   |     | NULL    |                |
 | is_active       | tinyint(1)   | NO   |     | NULL    |                |
 | blance          | int(11)      | NO   |     | 0       |                |
 +-----------------+--------------+------+-----+---------+----------------+

 +-------------+------------+------+-----+---------+----------------+
 | Field       | Type       | Null | Key | Default | Extra          |
 +-------------+------------+------+-----+---------+----------------+
 | id          | bigint(20) | NO   | PRI | NULL    | auto_increment |
 | user_id     | bigint(20) | NO   | MUL | NULL    |                |
 | coupon_id   | bigint(20) | NO   | MUL | NULL    |                |
 | create_time | timestamp  | YES  |     | NULL    |                |
 | start_time  | timestamp  | YES  |     | NULL    |                |
 | end_time    | timestamp  | YES  |     | NULL    |                |
 | is_invalid  | tinyint(1) | NO   |     | NULL    |                |
 +-------------+------------+------+-----+---------+----------------+
 */