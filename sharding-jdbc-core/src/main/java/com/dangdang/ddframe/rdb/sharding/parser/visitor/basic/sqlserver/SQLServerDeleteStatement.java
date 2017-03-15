package com.dangdang.ddframe.rdb.sharding.parser.visitor.basic.sqlserver;

import com.alibaba.druid.sql.ast.statement.SQLDeleteStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerObject;
import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerStatement;
import com.alibaba.druid.sql.dialect.sqlserver.visitor.SQLServerASTVisitor;
import com.alibaba.druid.sql.dialect.sqlserver.visitor.SQLServerOutputVisitor;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;
import com.alibaba.druid.util.JdbcConstants;

public class SQLServerDeleteStatement extends SQLDeleteStatement  implements SQLServerStatement {
	private SQLTableSource from;
	private SQLTableSource using;

	public SQLServerDeleteStatement() {
		super(JdbcConstants.SQL_SERVER);
	}

	public SQLTableSource getFrom() {
		return from;
	}

	public SQLTableSource getUsing() {
		return using;
	}

	public void setUsing(SQLTableSource using) {
		this.using = using;
	}

	public void setFrom(SQLTableSource from) {
		this.from = from;
	}

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof SQLServerASTVisitor) {
            accept0((SQLServerASTVisitor) visitor);
        } else {
            throw new IllegalArgumentException("not support visitor type : " + visitor.getClass().getName());
        }
    }

    public void output(StringBuffer buf) {
        new SQLServerOutputVisitor(buf).visit(this);
    }

    public void accept0(SQLServerASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, getTableSource());
            acceptChild(visitor, getWhere());
            acceptChild(visitor, getFrom());
            acceptChild(visitor, getUsing());
        }

        visitor.endVisit(this);
    }
}
