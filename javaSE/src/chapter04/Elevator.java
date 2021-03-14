package chapter04;

public class Elevator {
	private int current, max, min, request;
	private boolean isOpen;

	public Elevator() {
		min = 1;
		max = 1;
		current = 1;
	}

	public Elevator(int current, int max, int min, boolean isOpen) {
		this.current = current;
		this.max = max;
		this.min = min;
		this.isOpen = isOpen;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		if(current >= min && current <= max) {
			this.current = current;
		}else {
			System.err.println("잘못된 층을 설정했습니다.");
		}
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		if(request >= min && request <= max) {
			this.request = request;
		}else {
			System.err.println("잘못된 층을 설정했습니다.");
		}
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void choose(int floor) {
		if(floor == current) {
			System.out.println("요청한 층은 현재 층이므로 움직일 수 없습니다.");
		}else if(floor >max || floor <min) {
			System.out.println("요청한 층은 잘못된 층이므로 움직일 수 없습니다.");
		}else {
			request = floor;
			move();
		}
	}

	public void move() {
		if(isOpen) {
			close();
		}
		String msg = "올라가고";
		while(true) {
			if(current < request) {
				current++;
			}else if(current > request) {
				current--;
				msg = "내려가고";
			}else {
				System.out.printf("%d 층에 도착했습니다.\n", request);
				break;
			}
			if(current == 0) continue;
			System.out.printf("%d 층으로 %s 있습니다.\n", current, msg);
		}
		open();
	}

	public void open() {
		System.out.println("문이 열립니다.");
		isOpen = true;
	}

	public void close() {
		System.out.println("문이 닫힙니다.");
		isOpen = false;
	}
}
