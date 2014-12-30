package librarymanager.entity;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static librarymanager.util.StaticReferenceData.HYPHEN;
import static librarymanager.util.StaticReferenceData.TAB;
import static librarymanager.util.StatusEnum.BORROWED;
import static librarymanager.util.StatusEnum.RECEIEVED;

import java.util.Calendar;

import librarymanager.util.StatusEnum;

public class BookEntry {
	private String isbnCode;
	private String bookName;
	private StatusEnum status;
	private String borrowedBy;
	private String startDate;
	private String endDate;

	public String getIsbnCode() {
		return isbnCode;
	}

	public String getBookName() {
		return bookName;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public String getBorrowedBy() {
		return borrowedBy;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
	
	public BookEntry createBookEntry(String[] args) {
		StatusEnum status = StatusEnum.getEnumFrom(args[2]);
		String[] dates = createDates(status);
		
		BookEntry bookEntry = new BookEntry.Builder().isbnCode(args[0]) //
				.bookName(args[1]).status(status).borrowedBy(args[3]) //
				.startDate(dates[0]).endDate(dates[1]).build();
		
		return bookEntry;
	}
	
	private String[] createDates(StatusEnum status) {
			Calendar calender = Calendar.getInstance(); 
			String startDateString = createDate(calender);
			calender.add(DATE, status == BORROWED ? 14 : 9999);
			String endDateString = createDate(calender);
			return new String[] {startDateString, endDateString};
	}

	private String createDate(Calendar startDate) {
		StringBuilder date = new StringBuilder();
		date.append(startDate.get(DATE));
		date.append(HYPHEN);
		date.append(startDate.get(MONTH));
		date.append(HYPHEN);
		date.append(startDate.get(YEAR));
		return date.toString();
	}
	
	@Override
	public String toString() {
		return isbnCode + TAB + bookName + TAB + status.getSymbol() + TAB + borrowedBy + TAB + startDate + TAB + endDate;
	}

	public static class Builder {
		private String isbnCode;
		private String bookName;
		private StatusEnum status;
		private String borrowedBy;
		private String startDate;
		private String endDate;

		public Builder isbnCode(String isbnCode) {
			this.isbnCode = isbnCode;
			return this;
		}

		public Builder bookName(String bookName) {
			this.bookName = bookName;
			return this;
		}

		public Builder status(StatusEnum status) {
			this.status = status;
			return this;
		}

		public Builder borrowedBy(String borrowedBy) {
			this.borrowedBy = borrowedBy;
			return this;
		}

		public Builder startDate(String startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder endDate(String endDate) {
			this.endDate = endDate;
			return this;
		}

		public BookEntry build() {
			return new BookEntry(this);
		}
	}
	
	public BookEntry() {
//		Do Nothing
	}

	private BookEntry(Builder builder) {
		isbnCode = builder.isbnCode;
		bookName = builder.bookName;
		status = builder.status;
		borrowedBy = builder.borrowedBy;
		startDate = builder.startDate;
		endDate = builder.endDate;
	}
}
