
def two_digit(d):
    if d < 10:
        return f"0{d}"
    return str(d)

def get_is_leap_year(year):
    year = int(year)
    leap = True if year % 4 == 0 else False
    if year % 100 == 0:
        leap = True if year % 400 == 0 else False
    return leap

def days_of_month(is_leap_year, month):
    last_day_of_month = {
        1: 31,
        2: 28,
        3: 31,
        4: 30,
        5: 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10: 31,
        11: 30,
        12: 31,
    }
    return last_day_of_month[int(month)] + (1 if int(month) == 2 and is_leap_year else 0)

def days_since_month_head(is_leap_year, month, date_tail):
    month = str(month)
    if month != date_tail.split("-")[1]:
        return days_of_month(is_leap_year, month) + days_since_month_head(is_leap_year, two_digit(int(month) + 1), date_tail)

    return int(date_tail.split("-")[2]) - 1

def days_of_year(year):
    return 365 + (1 if get_is_leap_year(year) else 0)

def days_since_year_head(year_head, date_tail):
    if str(year_head) not in date_tail:
        return days_of_year(year_head) + days_since_year_head(int(year_head) + 1, date_tail)

    return days_since_month_head(get_is_leap_year(year_head), "01", date_tail)


class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        d1 = days_since_year_head("1900", date1)
        d2 = days_since_year_head("1900", date2)
        return abs(d1 - d2)


s = Solution()

date1 = "2019-06-29"
date2 = "2019-06-30"
print(s.daysBetweenDates(date1, date2))



