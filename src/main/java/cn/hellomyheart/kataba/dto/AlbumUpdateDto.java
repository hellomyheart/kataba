package cn.hellomyheart.kataba.dto;

import lombok.Data;

/**
 * @description
 * @className: AlbumUpdateDto
 * @package: cn.hellomyheart.kataba.dto
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:15
 */
@Data
public class AlbumUpdateDto {
    private String title;
    private String info;
    private Integer id;
}
