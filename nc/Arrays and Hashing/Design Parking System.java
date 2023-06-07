class ParkingSystem {
    int[] pk;
    public ParkingSystem(int big, int medium, int small) {
        pk=new int[3];
        pk[0]=big;
        pk[1]=medium;
        pk[2]=small;
    }
    
    public boolean addCar(int carType) {
        int index=carType-1;
        if(pk[index]>=1)
        {
            pk[index]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
