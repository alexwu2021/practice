package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dim_dates", schema = "dw", catalog = "")
public class DimDatesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "full_date")
    private Date fullDate;
    @Basic
    @Column(name = "date_name")
    private String dateName;
    @Basic
    @Column(name = "date_name_us")
    private String dateNameUs;
    @Basic
    @Column(name = "date_name_eu")
    private String dateNameEu;
    @Basic
    @Column(name = "day_of_week")
    private byte dayOfWeek;
    @Basic
    @Column(name = "day_name_of_week")
    private String dayNameOfWeek;
    @Basic
    @Column(name = "day_of_month")
    private byte dayOfMonth;
    @Basic
    @Column(name = "day_of_year")
    private short dayOfYear;
    @Basic
    @Column(name = "weekday_weekend")
    private String weekdayWeekend;
    @Basic
    @Column(name = "week_of_year")
    private byte weekOfYear;
    @Basic
    @Column(name = "month_name")
    private String monthName;
    @Basic
    @Column(name = "month_of_year")
    private byte monthOfYear;
    @Basic
    @Column(name = "is_last_day_of_month")
    private String isLastDayOfMonth;
    @Basic
    @Column(name = "calendar_quarter")
    private byte calendarQuarter;
    @Basic
    @Column(name = "calendar_year")
    private short calendarYear;
    @Basic
    @Column(name = "calendar_year_month")
    private String calendarYearMonth;
    @Basic
    @Column(name = "calendar_year_qtr")
    private String calendarYearQtr;
    @Basic
    @Column(name = "fiscal_month_of_year")
    private byte fiscalMonthOfYear;
    @Basic
    @Column(name = "fiscal_quarter")
    private byte fiscalQuarter;
    @Basic
    @Column(name = "fiscal_year")
    private int fiscalYear;
    @Basic
    @Column(name = "fiscal_year_month")
    private String fiscalYearMonth;
    @Basic
    @Column(name = "fiscal_year_qtr")
    private String fiscalYearQtr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFullDate() {
        return fullDate;
    }

    public void setFullDate(Date fullDate) {
        this.fullDate = fullDate;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public String getDateNameUs() {
        return dateNameUs;
    }

    public void setDateNameUs(String dateNameUs) {
        this.dateNameUs = dateNameUs;
    }

    public String getDateNameEu() {
        return dateNameEu;
    }

    public void setDateNameEu(String dateNameEu) {
        this.dateNameEu = dateNameEu;
    }

    public byte getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(byte dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayNameOfWeek() {
        return dayNameOfWeek;
    }

    public void setDayNameOfWeek(String dayNameOfWeek) {
        this.dayNameOfWeek = dayNameOfWeek;
    }

    public byte getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(byte dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public short getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(short dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public String getWeekdayWeekend() {
        return weekdayWeekend;
    }

    public void setWeekdayWeekend(String weekdayWeekend) {
        this.weekdayWeekend = weekdayWeekend;
    }

    public byte getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(byte weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public byte getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(byte monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public String getIsLastDayOfMonth() {
        return isLastDayOfMonth;
    }

    public void setIsLastDayOfMonth(String isLastDayOfMonth) {
        this.isLastDayOfMonth = isLastDayOfMonth;
    }

    public byte getCalendarQuarter() {
        return calendarQuarter;
    }

    public void setCalendarQuarter(byte calendarQuarter) {
        this.calendarQuarter = calendarQuarter;
    }

    public short getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(short calendarYear) {
        this.calendarYear = calendarYear;
    }

    public String getCalendarYearMonth() {
        return calendarYearMonth;
    }

    public void setCalendarYearMonth(String calendarYearMonth) {
        this.calendarYearMonth = calendarYearMonth;
    }

    public String getCalendarYearQtr() {
        return calendarYearQtr;
    }

    public void setCalendarYearQtr(String calendarYearQtr) {
        this.calendarYearQtr = calendarYearQtr;
    }

    public byte getFiscalMonthOfYear() {
        return fiscalMonthOfYear;
    }

    public void setFiscalMonthOfYear(byte fiscalMonthOfYear) {
        this.fiscalMonthOfYear = fiscalMonthOfYear;
    }

    public byte getFiscalQuarter() {
        return fiscalQuarter;
    }

    public void setFiscalQuarter(byte fiscalQuarter) {
        this.fiscalQuarter = fiscalQuarter;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getFiscalYearMonth() {
        return fiscalYearMonth;
    }

    public void setFiscalYearMonth(String fiscalYearMonth) {
        this.fiscalYearMonth = fiscalYearMonth;
    }

    public String getFiscalYearQtr() {
        return fiscalYearQtr;
    }

    public void setFiscalYearQtr(String fiscalYearQtr) {
        this.fiscalYearQtr = fiscalYearQtr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimDatesEntity that = (DimDatesEntity) o;
        return id == that.id && dayOfWeek == that.dayOfWeek && dayOfMonth == that.dayOfMonth && dayOfYear == that.dayOfYear && weekOfYear == that.weekOfYear && monthOfYear == that.monthOfYear && calendarQuarter == that.calendarQuarter && calendarYear == that.calendarYear && fiscalMonthOfYear == that.fiscalMonthOfYear && fiscalQuarter == that.fiscalQuarter && fiscalYear == that.fiscalYear && Objects.equals(fullDate, that.fullDate) && Objects.equals(dateName, that.dateName) && Objects.equals(dateNameUs, that.dateNameUs) && Objects.equals(dateNameEu, that.dateNameEu) && Objects.equals(dayNameOfWeek, that.dayNameOfWeek) && Objects.equals(weekdayWeekend, that.weekdayWeekend) && Objects.equals(monthName, that.monthName) && Objects.equals(isLastDayOfMonth, that.isLastDayOfMonth) && Objects.equals(calendarYearMonth, that.calendarYearMonth) && Objects.equals(calendarYearQtr, that.calendarYearQtr) && Objects.equals(fiscalYearMonth, that.fiscalYearMonth) && Objects.equals(fiscalYearQtr, that.fiscalYearQtr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullDate, dateName, dateNameUs, dateNameEu, dayOfWeek, dayNameOfWeek, dayOfMonth, dayOfYear, weekdayWeekend, weekOfYear, monthName, monthOfYear, isLastDayOfMonth, calendarQuarter, calendarYear, calendarYearMonth, calendarYearQtr, fiscalMonthOfYear, fiscalQuarter, fiscalYear, fiscalYearMonth, fiscalYearQtr);
    }
}
