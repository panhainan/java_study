package site.sixteen.designpattern;

import java.sql.ResultSet;

/**
 * @author panhainan@yeah.net(@link http://sixteen.site)
 **/
public interface RowHandler<T> {
    T handle(ResultSet rs);

}
