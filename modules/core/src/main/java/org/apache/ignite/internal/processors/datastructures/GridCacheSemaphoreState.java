package org.apache.ignite.internal.processors.datastructures;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.ignite.internal.processors.cache.GridCacheInternal;
import org.apache.ignite.internal.util.typedef.internal.S;

/**
 * Grid cache semaphore state.
 */
public class GridCacheSemaphoreState implements GridCacheInternal, Externalizable, Cloneable {
    /** */
    private static final long serialVersionUID = 0L;

    /**
     * Permission count.
     */
    private int count;

    /**
     * Waiter id.
     */
    private int waiters;

    /**
     * Fairness flag.
     */
    private boolean fair;

    /**
     * Constructor.
     *
     * @param count Number of permissions.
     */
    public GridCacheSemaphoreState(int count, int waiters) {
        this.count = count;
        this.waiters = waiters;
        this.fair = false;
    }

    /**
     * Constructor.
     *
     * @param count Number of permissions.
     */
    public GridCacheSemaphoreState(int count, int waiters, boolean fair) {
        this.count = count;
        this.waiters = waiters;
        this.fair = fair;
    }

    /**
     * Empty constructor required for {@link Externalizable}.
     */
    public GridCacheSemaphoreState() {
        // No-op.
    }

    /**
     * @param count New count.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return Current count.
     */
    public int getCount() {
        return count;
    }

    public int getWaiters() {
        return waiters;
    }

    public void setWaiters(int id) {
        this.waiters = id;
    }

    public boolean isFair() {
        return fair;
    }

    /**
     * {@inheritDoc}
     */
    @Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(count);
        out.writeInt(waiters);
        out.writeBoolean(fair);
    }

    /**
     * {@inheritDoc}
     */
    @Override public void readExternal(ObjectInput in) throws IOException {
        count = in.readInt();
        waiters = in.readInt();
        fair = in.readBoolean();
    }

    /**
     * {@inheritDoc}
     */
    @Override public String toString() {
        return S.toString(GridCacheSemaphoreState.class, this);
    }
}

