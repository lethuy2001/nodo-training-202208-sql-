package main;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetWarning;
import javax.sql.rowset.spi.SyncProvider;
import javax.sql.rowset.spi.SyncProviderException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName()) ;
    static Connection con = null ;
    CachedRowSet rowSet ;

    int pageSize = 5 ;

    public List<String> loadNames ( int page ) throws Exception {
        List<String> names = null;
        rowSet.setPageSize(page);
        int start = ( page - 1 ) * pageSize + 1 ;
        if( !rowSet.absolute(start) ){
            return names ;
        }
        rowSet.previous() ;
        while ( rowSet.next() ){
            names.add( rowSet.getString("name"));
            if( names.size() >= pageSize ) break;
        }
        return names ;
    }

    public DataAccessLogic() throws  Exception {
        con = ConnectionHelp.getConnection() ;

        rowSet = new CachedRowSet() {
            @Override
            public void populate(ResultSet data) throws SQLException {

            }

            @Override
            public void execute(Connection conn) throws SQLException {

            }

            @Override
            public void acceptChanges() throws SyncProviderException {

            }

            @Override
            public void acceptChanges(Connection con) throws SyncProviderException {

            }

            @Override
            public void restoreOriginal() throws SQLException {

            }

            @Override
            public void release() throws SQLException {

            }

            @Override
            public void undoDelete() throws SQLException {

            }

            @Override
            public void undoInsert() throws SQLException {

            }

            @Override
            public void undoUpdate() throws SQLException {

            }

            @Override
            public boolean columnUpdated(int idx) throws SQLException {
                return false;
            }

            @Override
            public boolean columnUpdated(String columnName) throws SQLException {
                return false;
            }

            @Override
            public Collection<?> toCollection() throws SQLException {
                return null;
            }

            @Override
            public Collection<?> toCollection(int column) throws SQLException {
                return null;
            }

            @Override
            public Collection<?> toCollection(String column) throws SQLException {
                return null;
            }

            @Override
            public SyncProvider getSyncProvider() throws SQLException {
                return null;
            }

            @Override
            public void setSyncProvider(String provider) throws SQLException {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public void setMetaData(RowSetMetaData md) throws SQLException {

            }

            @Override
            public ResultSet getOriginal() throws SQLException {
                return null;
            }

            @Override
            public ResultSet getOriginalRow() throws SQLException {
                return null;
            }

            @Override
            public void setOriginalRow() throws SQLException {

            }

            @Override
            public String getTableName() throws SQLException {
                return null;
            }

            @Override
            public void setTableName(String tabName) throws SQLException {

            }

            @Override
            public int[] getKeyColumns() throws SQLException {
                return new int[0];
            }

            @Override
            public void setKeyColumns(int[] keys) throws SQLException {

            }

            @Override
            public RowSet createShared() throws SQLException {
                return null;
            }

            @Override
            public CachedRowSet createCopy() throws SQLException {
                return null;
            }

            @Override
            public CachedRowSet createCopySchema() throws SQLException {
                return null;
            }

            @Override
            public CachedRowSet createCopyNoConstraints() throws SQLException {
                return null;
            }

            @Override
            public RowSetWarning getRowSetWarnings() throws SQLException {
                return null;
            }

            @Override
            public boolean getShowDeleted() throws SQLException {
                return false;
            }

            @Override
            public void setShowDeleted(boolean b) throws SQLException {

            }

            @Override
            public void commit() throws SQLException {

            }

            @Override
            public void rollback() throws SQLException {

            }

            @Override
            public void rollback(Savepoint s) throws SQLException {

            }

            @Override
            public void rowSetPopulated(RowSetEvent event, int numRows) throws SQLException {

            }

            @Override
            public void populate(ResultSet rs, int startRow) throws SQLException {

            }

            @Override
            public void setPageSize(int size) throws SQLException {

            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public boolean nextPage() throws SQLException {
                return false;
            }

            @Override
            public boolean previousPage() throws SQLException {
                return false;
            }

            @Override
            public String getUrl() throws SQLException {
                return null;
            }

            @Override
            public void setUrl(String url) throws SQLException {

            }

            @Override
            public String getDataSourceName() {
                return null;
            }

            @Override
            public void setDataSourceName(String name) throws SQLException {

            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public void setUsername(String name) throws SQLException {

            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public void setPassword(String password) throws SQLException {

            }

            @Override
            public int getTransactionIsolation() {
                return 0;
            }

            @Override
            public void setTransactionIsolation(int level) throws SQLException {

            }

            @Override
            public Map<String, Class<?>> getTypeMap() throws SQLException {
                return null;
            }

            @Override
            public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

            }

            @Override
            public String getCommand() {
                return null;
            }

            @Override
            public void setCommand(String cmd) throws SQLException {

            }

            @Override
            public boolean isReadOnly() {
                return false;
            }

            @Override
            public void setReadOnly(boolean value) throws SQLException {

            }

            @Override
            public int getMaxFieldSize() throws SQLException {
                return 0;
            }

            @Override
            public void setMaxFieldSize(int max) throws SQLException {

            }

            @Override
            public int getMaxRows() throws SQLException {
                return 0;
            }

            @Override
            public void setMaxRows(int max) throws SQLException {

            }

            @Override
            public boolean getEscapeProcessing() throws SQLException {
                return false;
            }

            @Override
            public void setEscapeProcessing(boolean enable) throws SQLException {

            }

            @Override
            public int getQueryTimeout() throws SQLException {
                return 0;
            }

            @Override
            public void setQueryTimeout(int seconds) throws SQLException {

            }

            @Override
            public void setType(int type) throws SQLException {

            }

            @Override
            public void setConcurrency(int concurrency) throws SQLException {

            }

            @Override
            public void setNull(int parameterIndex, int sqlType) throws SQLException {

            }

            @Override
            public void setNull(String parameterName, int sqlType) throws SQLException {

            }

            @Override
            public void setNull(int paramIndex, int sqlType, String typeName) throws SQLException {

            }

            @Override
            public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {

            }

            @Override
            public void setBoolean(int parameterIndex, boolean x) throws SQLException {

            }

            @Override
            public void setBoolean(String parameterName, boolean x) throws SQLException {

            }

            @Override
            public void setByte(int parameterIndex, byte x) throws SQLException {

            }

            @Override
            public void setByte(String parameterName, byte x) throws SQLException {

            }

            @Override
            public void setShort(int parameterIndex, short x) throws SQLException {

            }

            @Override
            public void setShort(String parameterName, short x) throws SQLException {

            }

            @Override
            public void setInt(int parameterIndex, int x) throws SQLException {

            }

            @Override
            public void setInt(String parameterName, int x) throws SQLException {

            }

            @Override
            public void setLong(int parameterIndex, long x) throws SQLException {

            }

            @Override
            public void setLong(String parameterName, long x) throws SQLException {

            }

            @Override
            public void setFloat(int parameterIndex, float x) throws SQLException {

            }

            @Override
            public void setFloat(String parameterName, float x) throws SQLException {

            }

            @Override
            public void setDouble(int parameterIndex, double x) throws SQLException {

            }

            @Override
            public void setDouble(String parameterName, double x) throws SQLException {

            }

            @Override
            public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {

            }

            @Override
            public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {

            }

            @Override
            public void setString(int parameterIndex, String x) throws SQLException {

            }

            @Override
            public void setString(String parameterName, String x) throws SQLException {

            }

            @Override
            public void setBytes(int parameterIndex, byte[] x) throws SQLException {

            }

            @Override
            public void setBytes(String parameterName, byte[] x) throws SQLException {

            }

            @Override
            public void setDate(int parameterIndex, Date x) throws SQLException {

            }

            @Override
            public void setTime(int parameterIndex, Time x) throws SQLException {

            }

            @Override
            public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {

            }

            @Override
            public void setTimestamp(String parameterName, Timestamp x) throws SQLException {

            }

            @Override
            public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {

            }

            @Override
            public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {

            }

            @Override
            public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException {

            }

            @Override
            public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {

            }

            @Override
            public void setAsciiStream(String parameterName, InputStream x) throws SQLException {

            }

            @Override
            public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {

            }

            @Override
            public void setBinaryStream(String parameterName, InputStream x) throws SQLException {

            }

            @Override
            public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {

            }

            @Override
            public void setCharacterStream(String parameterName, Reader reader) throws SQLException {

            }

            @Override
            public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {

            }

            @Override
            public void setObject(String parameterName, Object x, int targetSqlType, int scale) throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {

            }

            @Override
            public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {

            }

            @Override
            public void setObject(String parameterName, Object x) throws SQLException {

            }

            @Override
            public void setObject(int parameterIndex, Object x) throws SQLException {

            }

            @Override
            public void setRef(int i, Ref x) throws SQLException {

            }

            @Override
            public void setBlob(int i, Blob x) throws SQLException {

            }

            @Override
            public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {

            }

            @Override
            public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {

            }

            @Override
            public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {

            }

            @Override
            public void setBlob(String parameterName, Blob x) throws SQLException {

            }

            @Override
            public void setBlob(String parameterName, InputStream inputStream) throws SQLException {

            }

            @Override
            public void setClob(int i, Clob x) throws SQLException {

            }

            @Override
            public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setClob(int parameterIndex, Reader reader) throws SQLException {

            }

            @Override
            public void setClob(String parameterName, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setClob(String parameterName, Clob x) throws SQLException {

            }

            @Override
            public void setClob(String parameterName, Reader reader) throws SQLException {

            }

            @Override
            public void setArray(int i, Array x) throws SQLException {

            }

            @Override
            public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {

            }

            @Override
            public void setDate(String parameterName, Date x) throws SQLException {

            }

            @Override
            public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTime(String parameterName, Time x) throws SQLException {

            }

            @Override
            public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {

            }

            @Override
            public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {

            }

            @Override
            public void clearParameters() throws SQLException {

            }

            @Override
            public void execute() throws SQLException {

            }

            @Override
            public void addRowSetListener(RowSetListener listener) {

            }

            @Override
            public void removeRowSetListener(RowSetListener listener) {

            }

            @Override
            public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {

            }

            @Override
            public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {

            }

            @Override
            public void setRowId(int parameterIndex, RowId x) throws SQLException {

            }

            @Override
            public void setRowId(String parameterName, RowId x) throws SQLException {

            }

            @Override
            public void setNString(int parameterIndex, String value) throws SQLException {

            }

            @Override
            public void setNString(String parameterName, String value) throws SQLException {

            }

            @Override
            public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {

            }

            @Override
            public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException {

            }

            @Override
            public void setNCharacterStream(String parameterName, Reader value) throws SQLException {

            }

            @Override
            public void setNClob(String parameterName, NClob value) throws SQLException {

            }

            @Override
            public void setNClob(String parameterName, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setNClob(String parameterName, Reader reader) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, NClob value) throws SQLException {

            }

            @Override
            public void setNClob(int parameterIndex, Reader reader) throws SQLException {

            }

            @Override
            public void setURL(int parameterIndex, URL x) throws SQLException {

            }

            @Override
            public boolean next() throws SQLException {
                return false;
            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public boolean wasNull() throws SQLException {
                return false;
            }

            @Override
            public String getString(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public boolean getBoolean(int columnIndex) throws SQLException {
                return false;
            }

            @Override
            public byte getByte(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public short getShort(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public int getInt(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public long getLong(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public float getFloat(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public double getDouble(int columnIndex) throws SQLException {
                return 0;
            }

            @Override
            public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
                return null;
            }

            @Override
            public byte[] getBytes(int columnIndex) throws SQLException {
                return new byte[0];
            }

            @Override
            public Date getDate(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Time getTime(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Timestamp getTimestamp(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public InputStream getAsciiStream(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public InputStream getUnicodeStream(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public InputStream getBinaryStream(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public String getString(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public boolean getBoolean(String columnLabel) throws SQLException {
                return false;
            }

            @Override
            public byte getByte(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public short getShort(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public int getInt(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public long getLong(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public float getFloat(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public double getDouble(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
                return null;
            }

            @Override
            public byte[] getBytes(String columnLabel) throws SQLException {
                return new byte[0];
            }

            @Override
            public Date getDate(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Time getTime(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Timestamp getTimestamp(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public InputStream getAsciiStream(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public InputStream getUnicodeStream(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public InputStream getBinaryStream(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public SQLWarning getWarnings() throws SQLException {
                return null;
            }

            @Override
            public void clearWarnings() throws SQLException {

            }

            @Override
            public String getCursorName() throws SQLException {
                return null;
            }

            @Override
            public ResultSetMetaData getMetaData() throws SQLException {
                return null;
            }

            @Override
            public Object getObject(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Object getObject(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public int findColumn(String columnLabel) throws SQLException {
                return 0;
            }

            @Override
            public Reader getCharacterStream(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Reader getCharacterStream(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public boolean isBeforeFirst() throws SQLException {
                return false;
            }

            @Override
            public boolean isAfterLast() throws SQLException {
                return false;
            }

            @Override
            public boolean isFirst() throws SQLException {
                return false;
            }

            @Override
            public boolean isLast() throws SQLException {
                return false;
            }

            @Override
            public void beforeFirst() throws SQLException {

            }

            @Override
            public void afterLast() throws SQLException {

            }

            @Override
            public boolean first() throws SQLException {
                return false;
            }

            @Override
            public boolean last() throws SQLException {
                return false;
            }

            @Override
            public int getRow() throws SQLException {
                return 0;
            }

            @Override
            public boolean absolute(int row) throws SQLException {
                return false;
            }

            @Override
            public boolean relative(int rows) throws SQLException {
                return false;
            }

            @Override
            public boolean previous() throws SQLException {
                return false;
            }

            @Override
            public void setFetchDirection(int direction) throws SQLException {

            }

            @Override
            public int getFetchDirection() throws SQLException {
                return 0;
            }

            @Override
            public void setFetchSize(int rows) throws SQLException {

            }

            @Override
            public int getFetchSize() throws SQLException {
                return 0;
            }

            @Override
            public int getType() throws SQLException {
                return 0;
            }

            @Override
            public int getConcurrency() throws SQLException {
                return 0;
            }

            @Override
            public boolean rowUpdated() throws SQLException {
                return false;
            }

            @Override
            public boolean rowInserted() throws SQLException {
                return false;
            }

            @Override
            public boolean rowDeleted() throws SQLException {
                return false;
            }

            @Override
            public void updateNull(int columnIndex) throws SQLException {

            }

            @Override
            public void updateBoolean(int columnIndex, boolean x) throws SQLException {

            }

            @Override
            public void updateByte(int columnIndex, byte x) throws SQLException {

            }

            @Override
            public void updateShort(int columnIndex, short x) throws SQLException {

            }

            @Override
            public void updateInt(int columnIndex, int x) throws SQLException {

            }

            @Override
            public void updateLong(int columnIndex, long x) throws SQLException {

            }

            @Override
            public void updateFloat(int columnIndex, float x) throws SQLException {

            }

            @Override
            public void updateDouble(int columnIndex, double x) throws SQLException {

            }

            @Override
            public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {

            }

            @Override
            public void updateString(int columnIndex, String x) throws SQLException {

            }

            @Override
            public void updateBytes(int columnIndex, byte[] x) throws SQLException {

            }

            @Override
            public void updateDate(int columnIndex, Date x) throws SQLException {

            }

            @Override
            public void updateTime(int columnIndex, Time x) throws SQLException {

            }

            @Override
            public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {

            }

            @Override
            public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {

            }

            @Override
            public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {

            }

            @Override
            public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {

            }

            @Override
            public void updateObject(int columnIndex, Object x) throws SQLException {

            }

            @Override
            public void updateNull(String columnLabel) throws SQLException {

            }

            @Override
            public void updateBoolean(String columnLabel, boolean x) throws SQLException {

            }

            @Override
            public void updateByte(String columnLabel, byte x) throws SQLException {

            }

            @Override
            public void updateShort(String columnLabel, short x) throws SQLException {

            }

            @Override
            public void updateInt(String columnLabel, int x) throws SQLException {

            }

            @Override
            public void updateLong(String columnLabel, long x) throws SQLException {

            }

            @Override
            public void updateFloat(String columnLabel, float x) throws SQLException {

            }

            @Override
            public void updateDouble(String columnLabel, double x) throws SQLException {

            }

            @Override
            public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {

            }

            @Override
            public void updateString(String columnLabel, String x) throws SQLException {

            }

            @Override
            public void updateBytes(String columnLabel, byte[] x) throws SQLException {

            }

            @Override
            public void updateDate(String columnLabel, Date x) throws SQLException {

            }

            @Override
            public void updateTime(String columnLabel, Time x) throws SQLException {

            }

            @Override
            public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {

            }

            @Override
            public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {

            }

            @Override
            public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {

            }

            @Override
            public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {

            }

            @Override
            public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {

            }

            @Override
            public void updateObject(String columnLabel, Object x) throws SQLException {

            }

            @Override
            public void insertRow() throws SQLException {

            }

            @Override
            public void updateRow() throws SQLException {

            }

            @Override
            public void deleteRow() throws SQLException {

            }

            @Override
            public void refreshRow() throws SQLException {

            }

            @Override
            public void cancelRowUpdates() throws SQLException {

            }

            @Override
            public void moveToInsertRow() throws SQLException {

            }

            @Override
            public void moveToCurrentRow() throws SQLException {

            }

            @Override
            public Statement getStatement() throws SQLException {
                return null;
            }

            @Override
            public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
                return null;
            }

            @Override
            public Ref getRef(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Blob getBlob(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Clob getClob(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Array getArray(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
                return null;
            }

            @Override
            public Ref getRef(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Blob getBlob(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Clob getClob(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Array getArray(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Date getDate(int columnIndex, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public Date getDate(String columnLabel, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public Time getTime(int columnIndex, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public Time getTime(String columnLabel, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
                return null;
            }

            @Override
            public URL getURL(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public URL getURL(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public void updateRef(int columnIndex, Ref x) throws SQLException {

            }

            @Override
            public void updateRef(String columnLabel, Ref x) throws SQLException {

            }

            @Override
            public void updateBlob(int columnIndex, Blob x) throws SQLException {

            }

            @Override
            public void updateBlob(String columnLabel, Blob x) throws SQLException {

            }

            @Override
            public void updateClob(int columnIndex, Clob x) throws SQLException {

            }

            @Override
            public void updateClob(String columnLabel, Clob x) throws SQLException {

            }

            @Override
            public void updateArray(int columnIndex, Array x) throws SQLException {

            }

            @Override
            public void updateArray(String columnLabel, Array x) throws SQLException {

            }

            @Override
            public RowId getRowId(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public RowId getRowId(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public void updateRowId(int columnIndex, RowId x) throws SQLException {

            }

            @Override
            public void updateRowId(String columnLabel, RowId x) throws SQLException {

            }

            @Override
            public int getHoldability() throws SQLException {
                return 0;
            }

            @Override
            public boolean isClosed() throws SQLException {
                return false;
            }

            @Override
            public void updateNString(int columnIndex, String nString) throws SQLException {

            }

            @Override
            public void updateNString(String columnLabel, String nString) throws SQLException {

            }

            @Override
            public void updateNClob(int columnIndex, NClob nClob) throws SQLException {

            }

            @Override
            public void updateNClob(String columnLabel, NClob nClob) throws SQLException {

            }

            @Override
            public NClob getNClob(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public NClob getNClob(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public SQLXML getSQLXML(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public SQLXML getSQLXML(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {

            }

            @Override
            public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {

            }

            @Override
            public String getNString(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public String getNString(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public Reader getNCharacterStream(int columnIndex) throws SQLException {
                return null;
            }

            @Override
            public Reader getNCharacterStream(String columnLabel) throws SQLException {
                return null;
            }

            @Override
            public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {

            }

            @Override
            public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {

            }

            @Override
            public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {

            }

            @Override
            public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {

            }

            @Override
            public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {

            }

            @Override
            public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {

            }

            @Override
            public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {

            }

            @Override
            public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {

            }

            @Override
            public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {

            }

            @Override
            public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {

            }

            @Override
            public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {

            }

            @Override
            public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {

            }

            @Override
            public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {

            }

            @Override
            public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {

            }

            @Override
            public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {

            }

            @Override
            public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {

            }

            @Override
            public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {

            }

            @Override
            public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {

            }

            @Override
            public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {

            }

            @Override
            public void updateClob(int columnIndex, Reader reader) throws SQLException {

            }

            @Override
            public void updateClob(String columnLabel, Reader reader) throws SQLException {

            }

            @Override
            public void updateNClob(int columnIndex, Reader reader) throws SQLException {

            }

            @Override
            public void updateNClob(String columnLabel, Reader reader) throws SQLException {

            }

            @Override
            public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
                return null;
            }

            @Override
            public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public void setMatchColumn(int columnIdx) throws SQLException {

            }

            @Override
            public void setMatchColumn(int[] columnIdxes) throws SQLException {

            }

            @Override
            public void setMatchColumn(String columnName) throws SQLException {

            }

            @Override
            public void setMatchColumn(String[] columnNames) throws SQLException {

            }

            @Override
            public int[] getMatchColumnIndexes() throws SQLException {
                return new int[0];
            }

            @Override
            public String[] getMatchColumnNames() throws SQLException {
                return new String[0];
            }

            @Override
            public void unsetMatchColumn(int columnIdx) throws SQLException {

            }

            @Override
            public void unsetMatchColumn(int[] columnIdxes) throws SQLException {

            }

            @Override
            public void unsetMatchColumn(String columnName) throws SQLException {

            }

            @Override
            public void unsetMatchColumn(String[] columnName) throws SQLException {

            }
        };
        rowSet.setCommand("select * from student");
        rowSet.execute(con);

    }

    public void disconnect() throws Exception{
        try {
            if( con != null ){
                con.close();
            }
        }catch ( SQLException e ){
            logger.log( Level.WARNING , e.toString() );
        }
    }

    int numberOfPage( ) throws Exception {
        Statement statement = null ;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery( "select count(*) from student_lm_thuy");
            if( !rs.next() ){
                return 0 ;
            }
            int total = rs.getInt(1) ;
            int totalPage = total / pageSize ;
            if( total % pageSize != 0 ) totalPage++ ;
            return totalPage ;
        }finally {
            statement.close();
        }
    }
}
