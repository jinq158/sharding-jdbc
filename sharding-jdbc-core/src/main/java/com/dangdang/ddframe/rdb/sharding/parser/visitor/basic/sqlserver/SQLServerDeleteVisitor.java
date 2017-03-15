package com.dangdang.ddframe.rdb.sharding.parser.visitor.basic.sqlserver;

import com.alibaba.druid.sql.ast.statement.SQLDeleteStatement;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

public class SQLServerDeleteVisitor extends AbstractSQLServerVistor {
    public boolean visit(final SQLDeleteStatement stat) {
//    	Preconditions.checkArgument(stat instanceof SQLServerDeleteStatement);
//    	SQLServerDeleteStatement xx=(SQLServerDeleteStatement)stat;
//        getParseContext().setCurrentTable(xx.getTableName().toString(), Optional.fromNullable(xx.getAlias()));
//        
//        print("DELETE ");
//
//         
//        if (xx.getFrom() == null) {
//            print("FROM ");
//            xx.getTableSource().accept(this);
//        } else {
//            xx.getTableSource().accept(this);
//            println();
//            print("FROM ");
//            xx.getFrom().accept(this);
//        }
// 
//
//        if (xx.getWhere() != null) {
//            println();
//            incrementIndent();
//            print("WHERE ");
//            xx.getWhere().setParent(xx);
//            xx.getWhere().accept(this);
//            decrementIndent();
//        }
//
//        if (x.getOrderBy() != null) {
//            println();
//            x.getOrderBy().accept(this);
//        }

       

        return super.visit(stat);
    }
	 
}
