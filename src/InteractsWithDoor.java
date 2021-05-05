public class InteractsWithDoor implements InteractsWith {
    private Door door;

    @Override
    public Asset getAssetType() {
        return door;
    }
}
