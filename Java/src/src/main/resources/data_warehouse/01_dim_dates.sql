# use dw;

# https://gist.github.com/ficus/ca48b3c1ffbe9f77eda0ad2d501cb8ce
drop table if exists dim_dates;
CREATE TABLE dim_dates(
     id int NOT NULL,
     full_date date NULL,
     date_name char(11) NOT NULL,
     date_name_us char(11) NOT NULL,
     date_name_eu char(11) NOT NULL,
     day_of_week tinyint NOT NULL,
     day_name_of_week char(10) NOT NULL,
     day_of_month tinyint NOT NULL,
     day_of_year smallint NOT NULL,
     weekday_weekend char(10) NOT NULL,
     week_of_year tinyint NOT NULL,
     month_name char(10) NOT NULL,
     month_of_year tinyint NOT NULL,
     is_last_day_of_month char(1) NOT NULL,
     calendar_quarter tinyint NOT NULL,
     calendar_year smallint NOT NULL,
     calendar_year_month char(10) NOT NULL,
     calendar_year_qtr char(10) NOT NULL,
     fiscal_month_of_year tinyint NOT NULL,
     fiscal_quarter tinyint NOT NULL,
     fiscal_year int NOT NULL,
     fiscal_year_month char(10) NOT NULL,
     fiscal_year_qtr char(10) NOT NULL,
     PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


delimiter //

drop procedure if exists PopulateDateDimension//

CREATE PROCEDURE PopulateDateDimension(BeginDate DATETIME, EndDate DATETIME)
BEGIN


    DECLARE LastDayOfMon CHAR(1);
    DECLARE FiscalYearMonthsOffset INT;

    DECLARE DateCounter DATETIME;    #Current date in loop
    DECLARE FiscalCounter DATETIME;  #Fiscal Year Date in loop

    # Set this to the number of months to add to the current date to get
    # the beginning of the Fiscal year. For example, if the Fiscal year
    # begins July 1, put a 6 there.
    # Negative values are also allowed, thus if your 2010 Fiscal year
    # begins in July of 2009, put a -6.
    SET FiscalYearMonthsOffset = 6;

    # Start the counter at the begin date
    SET DateCounter = BeginDate;

    WHILE DateCounter <= EndDate DO
        # Calculate the current Fiscal date as an offset of
        # the current date in the loop

            SET FiscalCounter = DATE_ADD(DateCounter, INTERVAL FiscalYearMonthsOffset MONTH);

            # Set value for IsLastDayOfMonth
            IF MONTH(DateCounter) = MONTH(DATE_ADD(DateCounter, INTERVAL 1 DAY)) THEN
                SET LastDayOfMon = 'N';
            ELSE
                SET LastDayOfMon = 'Y';
            END IF;

            # add a record into the date dimension table for this date
            INSERT  INTO dim_dates
            (id
            ,full_date
            ,date_name
            ,date_name_us
            ,date_name_eu
            ,day_of_week
            ,day_name_of_week
            ,day_of_month
            ,day_of_year
            ,weekday_weekend
            ,week_of_year
            ,month_name
            ,month_of_year
            ,is_last_day_of_month
            ,calendar_quarter
            ,calendar_year
            ,calendar_year_month
            ,calendar_year_qtr
            ,fiscal_month_of_year
            ,fiscal_quarter
            ,fiscal_year
            ,fiscal_year_month
            ,fiscal_year_qtr)
            VALUES  (
                            ( YEAR(DateCounter) * 10000 ) + ( MONTH(DateCounter)
                            * 100 )
                            + DAY(DateCounter)  #DateKey
                    , DateCounter # FullDate
                    , CONCAT(CAST(YEAR(DateCounter) AS CHAR(4)),'/',DATE_FORMAT(DateCounter,'%m'),'/',DATE_FORMAT(DateCounter,'%d')) #DateName
                    , CONCAT(DATE_FORMAT(DateCounter,'%m'),'/',DATE_FORMAT(DateCounter,'%d'),'/',CAST(YEAR(DateCounter) AS CHAR(4)))#DateNameUS
                    , CONCAT(DATE_FORMAT(DateCounter,'%d'),'/',DATE_FORMAT(DateCounter,'%m'),'/',CAST(YEAR(DateCounter) AS CHAR(4)))#DateNameEU
                    , DAYOFWEEK(DateCounter) #DayOfWeek
                    , DAYNAME(DateCounter) #DayNameOfWeek
                    , DAYOFMONTH(DateCounter) #DayOfMonth
                    , DAYOFYEAR(DateCounter) #DayOfYear
                    , CASE DAYNAME(DateCounter)
                          WHEN 'Saturday' THEN 'Weekend'
                          WHEN 'Sunday' THEN 'Weekend'
                          ELSE 'Weekday'
                                END #WeekdayWeekend
                    , WEEKOFYEAR(DateCounter) #WeekOfYear
                    , MONTHNAME(DateCounter) #MonthName
                    , MONTH(DateCounter) #MonthOfYear
                    , LastDayOfMon #IsLastDayOfMonth
                    , QUARTER(DateCounter) #CalendarQuarter
                    , YEAR(DateCounter) #CalendarYear
                    , CONCAT(CAST(YEAR(DateCounter) AS CHAR(4)),'-',DATE_FORMAT(DateCounter,'%m')) #CalendarYearMonth
                    , CONCAT(CAST(YEAR(DateCounter) AS CHAR(4)),'Q',QUARTER(DateCounter)) #CalendarYearQtr
                    , MONTH(FiscalCounter) #[FiscalMonthOfYear]
                    , QUARTER(FiscalCounter) #[FiscalQuarter]
                    , YEAR(FiscalCounter) #[FiscalYear]
                    , CONCAT(CAST(YEAR(FiscalCounter) AS CHAR(4)),'-',DATE_FORMAT(FiscalCounter,'%m')) #[FiscalYearMonth]
                    , CONCAT(CAST(YEAR(FiscalCounter) AS CHAR(4)),'Q',QUARTER(FiscalCounter)) #[FiscalYearQtr]
                    );

            # Increment the date counter for next pass thru the loop
            SET DateCounter = DATE_ADD(DateCounter, INTERVAL 1 DAY);
        END WHILE;


END//

CALL PopulateDateDimension('2010/01/01', '2025/12/31');