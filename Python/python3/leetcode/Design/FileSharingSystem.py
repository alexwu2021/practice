from collections import defaultdict
from typing import List
import itertools

class FileSharing:

    def __init__(self, m: int):
        self.chunk_2_uids = defaultdict(set)
        self.uid_2_chunks = defaultdict(set)
        self.nextID = 1

    def join(self, owned_chunks: List[int]) -> int:
        uid = self.nextID
        for i in itertools.count(uid + 1):
            if i not in self.uid_2_chunks:
                self.nextID = i
                break
        self.uid_2_chunks[uid] = set(owned_chunks)
        for ch in owned_chunks:
            self.chunk_2_uids[ch].add(uid)
        return uid

    def leave(self, user_id: int) -> None:
        if user_id < self.nextID:
            self.nextID = user_id
        for ch in self.uid_2_chunks[user_id]:
            self.chunk_2_uids[ch].remove(user_id)
        del self.uid_2_chunks[user_id]

    def request(self, user_id: int, chunk_id: int) -> List[int]:
        ans = sorted(self.chunk_2_uids[chunk_id])
        if ans:
            self.chunk_2_uids[chunk_id].add(user_id)
            self.uid_2_chunks[user_id].add(chunk_id)
        return ans
